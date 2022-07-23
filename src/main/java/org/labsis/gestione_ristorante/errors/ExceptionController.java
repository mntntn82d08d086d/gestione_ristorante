package org.labsis.gestione_ristorante.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {



    @ExceptionHandler(FornitorePivaException.class)
    public String fornitorePivaException(FornitorePivaException ex, Model model) {
        int flag=1;
        model.addAttribute("obj", flag);
        return "redirect:/magazzino/fornitori" ;



    }

    @ExceptionHandler(UnexpectedRollbackException.class)
    public String unexpectedRollbackException (UnexpectedRollbackException ex, Model model){
        int flag=2;
        model.addAttribute("obj", flag);
        return "redirect:/magazzino/fornitori" ;
    }
}
