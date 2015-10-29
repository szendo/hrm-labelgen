(function ready(fn) {
    if (document.readyState != 'loading') {
        fn();
    } else {
        document.addEventListener('DOMContentLoaded', fn);
    }
})(function () {

    var form = document.getElementById('form');
    var submit = document.getElementById('submit');
    var result = document.getElementById('result');

    submit.addEventListener('click', function (e) {
        e.preventDefault();

        var data = collectFormData(form);
        var xmlHttpRequest = new XMLHttpRequest();
        xmlHttpRequest.open('POST', form.action);
        xmlHttpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xmlHttpRequest.onload = function () {
            result.value = xmlHttpRequest.response.toString();
        };
        xmlHttpRequest.send(data);
    });

    function collectFormData(form) {
        return Array.prototype.filter.call(form.elements, function (e) {
            return e.name;
        }).map(function (e) {
            return encodeURIComponent(e.name) + '=' + encodeURIComponent(e.value)
        }).join('&')
    }

});