package org.labsis.gestione_ristorante.errors;

import org.springframework.transaction.UnexpectedRollbackException;

public class FornitorePivaException extends UnexpectedRollbackException {

    public FornitorePivaException(String piva) {
        super(String.format("Partita iva %s non conforme",piva));
    }
}
