CREATE TRIGGER `fornitore_piva_validate_insert`
BEFORE INSERT
        ON fornitore
        FOR EACH ROW
BEGIN
    IF (LENGTH(New.piva) > 21) OR (LENGTH(New.piva) < 21) THEN
        SIGNAL SQLSTATE VALUE '45000'
            SET MESSAGE_TEXT = '[table:fornitore] - `piva` column is not valid';
    END IF;
END;

INSERT INTO fornitore (piva, citta, nome_azienda, sede_legale) VALUES ('123123123123123123123','cit','nom','sed');

DROP TRIGGER fornitore_piva_validate_insert;

CREATE TRIGGER `account_email_validate_insert`
    BEFORE INSERT
    ON account
    FOR EACH ROW
    BEGIN
       IF NEW.`email` NOT LIKE '%_@%_.__%' THEN
           SIGNAL SQLSTATE VALUE '45000'
               SET MESSAGE_TEXT = '[table:account] - `email` column is not valid';
       END IF;
    END;

INSERT INTO account (email, username, password) VALUES ('ciccio@ciccio.ci', 'ciccio', 'ciccio');

DROP TRIGGER account_email_validate_insert;