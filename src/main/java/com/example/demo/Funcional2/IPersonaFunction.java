package com.example.demo.Funcional2;

@FunctionalInterface
public interface IPersonaFunction<T, R> {

	public T aplicar(R arg);
}
