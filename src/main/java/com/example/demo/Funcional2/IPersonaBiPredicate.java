package com.example.demo.Funcional2;

@FunctionalInterface
public interface IPersonaBiPredicate<T, R> {

	public boolean evaluar(T arg1, R arg2);
}
