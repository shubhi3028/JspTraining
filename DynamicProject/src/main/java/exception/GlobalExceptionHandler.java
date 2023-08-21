package exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserRegistrationException.class)
    public ModelAndView handleUserRegistrationException(UserRegistrationException ex) {
        ModelAndView modelAndView = new ModelAndView("error-page");
        modelAndView.addObject("errorMessage", "User registration failed: " + ex.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(AdminAccessException.class)
    public ModelAndView handleAdminAccessException(AdminAccessException ex) {
        ModelAndView modelAndView = new ModelAndView("error-page");
        modelAndView.addObject("errorMessage", "Admin access error: " + ex.getMessage());
        return modelAndView;
    }
}

