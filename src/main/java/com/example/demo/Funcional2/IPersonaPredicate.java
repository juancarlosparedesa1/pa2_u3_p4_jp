package com.example.demo.Funcional2;

@FunctionalInterface
public interface IPersonaPredicate<T> {

	public boolean evaluar(T arg);
}
