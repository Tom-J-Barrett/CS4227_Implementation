package Validation;

public interface ValidationRule<T> {
    void validate(T validationData);
}
