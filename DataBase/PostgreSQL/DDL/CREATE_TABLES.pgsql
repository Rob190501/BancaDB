CREATE TABLE ContoCorrente (
    IBAN VARCHAR(27),
    saldo INTEGER,
    CFCorrentista VARCHAR(16),

    CONSTRAINT pkCC PRIMARY KEY (IBAN)
);

CREATE TABLE Correntista (
    CF VARCHAR(16),
    nome VARCHAR(30),
    cognome VARCHAR(30),
    dataN DATE,

    CONSTRAINT pkC PRIMARY KEY (CF)
);

ALTER TABLE ContoCorrente
    ADD CONSTRAINT fkCC FOREIGN KEY (CFCorrentista) REFERENCES Correntista (CF);

    Drop table contocorrente;