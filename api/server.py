from fastapi import FastAPI
from ai_core.agents.manager_agent import ManagerAgent
from ai_core.agents.diagnostic_agent import DiagnosticAgent
from ai_core.agents.mqtt_agent import MqttAgent

app = FastAPI(title="Jaguar IA", version="1.0")

manager = ManagerAgent()
manager.atualizar()

diagnostic = DiagnosticAgent()
mqtt = MqttAgent()

@app.get("/perguntar")
def perguntar(q: str):
    return {"resposta": manager.vs.search(q)}

@app.get("/diagnosticar")
def diagnosticar(sintoma: str):
    return diagnostic.diagnosticar(sintoma)

@app.post("/comando")
def comando(dispositivo: str, acao: str):
    mqtt.enviar_comando(dispositivo, acao)
    return {"status": "comando enviado", "dispositivo": dispositivo, "acao": acao}
