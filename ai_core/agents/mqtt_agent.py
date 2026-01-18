import paho.mqtt.client as mqtt
import json

BROKER = "test.mosquitto.org"
PORT = 1883

class MqttAgent:
    def __init__(self):
        self.client = mqtt.Client()
        self.client.on_message = self.on_message
        self.client.connect(BROKER, PORT, 60)

        self.client.subscribe("jaguar/esp32/status")
        self.client.loop_start()

    def on_message(self, client, userdata, msg):
        payload = msg.payload.decode()
        print(f"[MQTT STATUS] {msg.topic}: {payload}")

    def enviar_comando(self, dispositivo, acao):
        comando = {
            "dispositivo": dispositivo,
            "acao": acao
        }
        self.client.publish("jaguar/esp32/comando", json.dumps(comando))
