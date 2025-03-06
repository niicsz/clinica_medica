function validarCPF(cpf) {
    cpf = cpf.replace(/[^\d]+/g, '');
    if (cpf.length !== 11) {
        return false;
    }

    if (/^(\d)\1{10}$/.test(cpf)) {
        return false;
    }

    let soma = 0;
    let resto;

    for (let i = 1; i <= 9; i++) {
        soma = soma + parseInt(cpf.substring(i-1, i)) * (11 - i);
    }

    resto = (soma * 10) % 11;

    if ((resto === 10) || (resto === 11)) {
        resto = 0;
    }

    if (resto !== parseInt(cpf.substring(9, 10))) {
        return false;
    }

    soma = 0;

    for (let i = 1; i <= 10; i++) {
        soma = soma + parseInt(cpf.substring(i-1, i)) * (12 - i);
    }

    resto = (soma * 10) % 11;

    if ((resto === 10) || (resto === 11)) {
        resto = 0;
    }

    if (resto !== parseInt(cpf.substring(10, 11))) {
        return false;
    }

    return true;
}

function formatarCPF(cpf) {
    cpf = cpf.replace(/[^\d]/g, '');
    return cpf.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, "$1.$2.$3-$4");
}

document.addEventListener('DOMContentLoaded', function() {
    const cpfInputs = document.querySelectorAll('input[id="cpf"]');

    cpfInputs.forEach(function(input) {
        input.addEventListener('blur', function() {
            const cpfValue = this.value.replace(/[^\d]/g, '');

            if (cpfValue.length !== 11) {
                this.classList.add('is-invalid');
                this.setCustomValidity('CPF deve ter 11 dígitos');
            } else if (!validarCPF(cpfValue)) {
                this.classList.add('is-invalid');
                this.setCustomValidity('CPF inválido');
            } else {
                this.classList.remove('is-invalid');
                this.classList.add('is-valid');
                this.setCustomValidity('');
            }
        });
    });

    const emailInputs = document.querySelectorAll('input[type="email"]');

    emailInputs.forEach(function(input) {
        input.addEventListener('blur', function() {
            const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

            if (!emailRegex.test(this.value)) {
                this.classList.add('is-invalid');
                this.setCustomValidity('E-mail inválido');
            } else {
                this.classList.remove('is-invalid');
                this.classList.add('is-valid');
                this.setCustomValidity('');
            }
        });
    });

    const tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
    tooltipTriggerList.map(function(tooltipTriggerEl) {
        return new bootstrap.Tooltip(tooltipTriggerEl);
    });

    const deleteButtons = document.querySelectorAll('.btn-delete');
    deleteButtons.forEach(function(button) {
        button.addEventListener('click', function(event) {
            if (!confirm('Tem certeza que deseja excluir este item? Esta ação não pode ser desfeita.')) {
                event.preventDefault();
            }
        });
    });

    const forms = document.querySelectorAll('form');
    forms.forEach(function(form) {
        form.addEventListener('submit', function(event) {
            if (!this.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
            }

            this.classList.add('was-validated');
        });
    });

    const dataHoraInputs = document.querySelectorAll('input[type="datetime-local"]');
    dataHoraInputs.forEach(function(input) {
        input.addEventListener('change', function() {
            const selectedDate = new Date(this.value);
            const now = new Date();

            if (selectedDate <= now) {
                this.classList.add('is-invalid');
                this.setCustomValidity('A data e hora da consulta deve ser futura');
            } else {
                this.classList.remove('is-invalid');
                this.classList.add('is-valid');
                this.setCustomValidity('');
            }
        });
    });
});