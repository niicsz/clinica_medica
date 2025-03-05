function validarCPF(cpf) {
    cpf = cpf.replace(/[^\d]+/g, '');
    if (cpf.length !== 11) {
        return false;
    }
    return true;
}

document.addEventListener('DOMContentLoaded', function() {
    // Adiciona validação nos campos de CPF
    const cpfInputs = document.querySelectorAll('input[id="cpf"]');

    cpfInputs.forEach(function(input) {
        input.addEventListener('blur', function() {
            if (!validarCPF(this.value)) {
                this.classList.add('is-invalid');
                this.setCustomValidity('CPF deve ter 11 dígitos');
            } else {
                this.classList.remove('is-invalid');
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
            if (!confirm('Tem certeza que deseja excluir este item?')) {
                event.preventDefault();
            }
        });
    });
});