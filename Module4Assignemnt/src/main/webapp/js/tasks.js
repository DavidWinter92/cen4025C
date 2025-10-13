function updateTask(id, newDescription) {
    var form = document.createElement('form');
    form.method = 'POST';
    form.action = 'tasks';

    var idField = document.createElement('input');
    idField.type = 'hidden';
    idField.name = 'id';
    idField.value = id;

    var actionField = document.createElement('input');
    actionField.type = 'hidden';
    actionField.name = 'action';
    actionField.value = 'update';

    var descField = document.createElement('input');
    descField.type = 'hidden';
    descField.name = 'newDescription';
    descField.value = newDescription;

    form.appendChild(idField);
    form.appendChild(actionField);
    form.appendChild(descField);

    document.body.appendChild(form);
    form.submit();
}
