import sqlite3

class VectorStore:
    def __init__(self):
        self.conn = sqlite3.connect("data/knowledge.db")
        self.conn.execute(
            "CREATE TABLE IF NOT EXISTS knowledge (id INTEGER PRIMARY KEY, text TEXT)"
        )

    def add(self, text):
        self.conn.execute(
            "INSERT INTO knowledge (text) VALUES (?)",
            (text,)
        )
        self.conn.commit()

    def search(self, termo):
        cur = self.conn.execute(
            "SELECT text FROM knowledge WHERE text LIKE ? LIMIT 5",
            (f"%{termo}%",)
        )
        return [r[0] for r in cur.fetchall()]
