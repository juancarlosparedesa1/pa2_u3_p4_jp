package com.example.demo.funcional;

@FunctionalInterface
public interface IPersonaUnaryOperator<T> {

	// la mas comun
	public T aplicar(T arg);
}
