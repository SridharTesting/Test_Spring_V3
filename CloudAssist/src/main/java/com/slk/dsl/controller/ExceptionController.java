package com.slk.dsl.controller;



import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

public class ExceptionController {
    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest request, Exception e)   {
        
        return new ModelAndView("error");
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleError404(HttpServletRequest request, Exception e)   {
      
        return new ModelAndView("404");
    }
    
    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleError500(HttpServletRequest request, Exception e)   {
      
        return new ModelAndView("500");
    }
}
