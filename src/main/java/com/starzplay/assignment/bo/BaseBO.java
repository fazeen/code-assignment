package com.starzplay.assignment.bo;

public interface BaseBO<B,E> {
    E convertToEntity();
    B convertToBO(E entity);
    B convertToNewBO(E entity);
}
