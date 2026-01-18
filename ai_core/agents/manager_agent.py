from ai_core.agents.knowledge_agent import KnowledgeAgent
from ai_core.rag.vector_store import VectorStore

class ManagerAgent:
    def __init__(self):
        self.ka = KnowledgeAgent()
        self.vs = VectorStore()

    def atualizar(self):
        temas = [
            "ESP32 automação",
            "CLP Siemens",
            "Automação residencial MQTT",
            "Modbus RTU"
        ]

        for tema in temas:
            dados = self.ka.buscar(tema)
            for d in dados:
                self.vs.add(d)
