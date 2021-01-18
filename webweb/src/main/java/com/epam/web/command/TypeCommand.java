package com.epam.web.command;

import com.epam.web.command.impl.*;

public enum TypeCommand {
    DELETE_ACCOUNT(new DeleteAccountCommand()),
    REDIRECT_TO_ACCOUNT(new RedirectToAccountCommand()),
    REDIRECT_TO_REGISTRATION(new RedirectToRegistrationCommand()),
    REDIRECT_TO_LOGIN(new RedirectToLoginCommand()),
    ACTIVATION(new ActivationCommand()),
    CHANGE_LOCALE(new ChangeLocaleCommand()),
    REGISTRATION(new RegistrationCommand()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    ADD_PRODUCT(new AddProductCommand());

    private Command command;

    TypeCommand(Command command) {
        this.command = command;
    }

    public Command getCommand(){
        return command;
    }
}
