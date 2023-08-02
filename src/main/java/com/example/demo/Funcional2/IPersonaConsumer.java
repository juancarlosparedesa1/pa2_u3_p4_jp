package com.example.demo.Funcional2;

@FunctionalInterface
public interface IPersonaConsumer<T> {

	public void accept(T arg);
}
