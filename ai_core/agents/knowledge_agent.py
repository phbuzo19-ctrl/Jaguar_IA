import requests
from bs4 import BeautifulSoup

HEADERS = {
    "User-Agent": "Mozilla/5.0 (Android 13; Mobile; rv:109.0) Gecko/109.0 Firefox/109.0"
}

class KnowledgeAgent:
    def buscar(self, tema):
        resultados = []

        # Fonte 1 — Wikipedia (confiável)
        wiki_url = f"https://pt.wikipedia.org/wiki/{tema.replace(' ', '_')}"
        try:
            r = requests.get(wiki_url, headers=HEADERS, timeout=10)
            soup = BeautifulSoup(r.text, "html.parser")
            for p in soup.select("p")[:3]:
                texto = p.text.strip()
                if len(texto) > 60:
                    resultados.append(texto)
        except Exception:
            pass

        # Fonte 2 — Busca técnica simulada (industrial)
        resultados.append(f"{tema} é amplamente usado em automação industrial e residencial.")
        resultados.append(f"{tema} pode ser integrado com CLPs, sensores e protocolos como MQTT e Modbus.")

        return resultados
