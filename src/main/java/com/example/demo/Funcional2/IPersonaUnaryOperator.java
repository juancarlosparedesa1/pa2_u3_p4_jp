package com.example.demo.Funcional2;

@FunctionalInterface
public interface IPersonaUnaryOperator<T> {

	// la mas comun
	public T aplicar(T arg);
}
