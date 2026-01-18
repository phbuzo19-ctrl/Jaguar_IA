from ai_core.rag.vector_store import VectorStore

class DiagnosticAgent:
    def __init__(self):
        self.vs = VectorStore()

    def diagnosticar(self, sintoma):
        conhecimento = self.vs.search(sintoma)

        if not conhecimento:
            return {
                "causa": "Informação insuficiente",
                "acao": "Verificar alimentação, comunicação e parametrização"
            }

        return {
            "causa": f"Possível relação com: {conhecimento[0]}",
            "acao": "Inspecionar cabos, parâmetros e firmware do dispositivo"
        }
