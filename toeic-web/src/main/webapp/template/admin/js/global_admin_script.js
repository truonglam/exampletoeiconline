$(document).ready(function () {
    bindEventCheckAllCheckBox('checkAll')
});
function bindEventCheckAllCheckBox(id) {
    $('#' + id).on('change', function () {
        if ((this).checked) {
            //enable all checkbox
            $(this).closest('table').find('input[type=checkbox]').prop('checked', true);
        } else {
            //disable all checkbox
            $(this).closest('table').find('input[type=checkbox]').prop('checked', false);
        }
    });
}

