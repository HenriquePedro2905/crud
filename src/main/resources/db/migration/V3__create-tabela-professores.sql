CREATE TABLE professores(
    id  TEXT PRIMARY KEY UNIQUE NOT NULL,
    nome TEXT NOT NULL,
    materia TEXT,
    salarioInCents INTEGER
);