package io.quind.training.basicconsoleapp.domain;

public interface Calculator<T extends Number> {
    double calculateFees(T clubID);
}
