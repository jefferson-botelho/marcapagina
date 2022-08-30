package com.marcapagina.aplicacao.exception;

public class ExcecaoDeNegocio extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcecaoDeNegocio() {
    }

    public ExcecaoDeNegocio(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

    public ExcecaoDeNegocio(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public ExcecaoDeNegocio(String arg0) {
        super(arg0);
    }

    public ExcecaoDeNegocio(Throwable arg0) {
        super(arg0);
    }
}
