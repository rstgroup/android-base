package com.rstit.ui.auth.password;

import android.support.annotation.Nullable;

import com.rstit.binding.ObservableString;
import com.rstit.di.names.EmailValidatorName;
import com.rstit.validation.Validator;

import javax.inject.Inject;

/**
 * @author Tomasz Trybala
 * @since 2017-05-26
 */

public class ForgotPasswordViewModel {
    public final ObservableString mLogin = new ObservableString();
    public final ObservableString mLoginError = new ObservableString();

    @Inject
    protected ForgotPasswordViewAccess mViewAccess;

    @Inject
    @EmailValidatorName
    protected Validator mLoginValidator;

    @Inject
    public ForgotPasswordViewModel() {
    }

    protected void setLoginValidator(@Nullable Validator loginValidator) {
        mLoginValidator = loginValidator;
    }

    public boolean isValidateLogin() {
        boolean valid = true;

        if (mLoginValidator != null && !mLoginValidator.isValid(mLogin.get())) {
            mLoginError.set(mViewAccess.getLoginErrorMessage());
            valid = false;
        } else {
            mLoginError.set(null);
        }

        return valid;
    }
}
