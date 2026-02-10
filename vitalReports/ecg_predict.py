import sys
import json
import numpy as np
import tensorflow as tf

WINDOW_SIZE = 180

# Load trained model
model = tf.keras.models.load_model("ecg_cnn_mitbih.keras")

# Read input from Java (JSON string)
input_data = json.loads(sys.argv[1])

signal = np.array(input_data["signal"])
signal = signal / np.max(np.abs(signal))
signal = signal.reshape(1, WINDOW_SIZE, 1)

# Predict
prob = float(model.predict(signal)[0][0])
label = "Abnormal" if prob > 0.5 else "Normal"

# Output JSON
result = {
    "prediction": label,
    "probability": round(prob, 4)
}

print(json.dumps(result))
