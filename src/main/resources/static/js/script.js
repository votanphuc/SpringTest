$("#checkAll").click(function () {
    $('input:checkbox').not(this).prop('checked', this.checked);
    checkCount();
});

$(".checkItem").click(function () {
    checkCount();
});

function checkCount() {
    var inputElems = document.getElementsByTagName("input");
        count = 0;
    $.each($("input[name=checkItem]:checked"), function (item, index) {
        count++;
    })
    $("#selectedItem").text(count);;
};

var form = document.getElementById("upload-music");
 $("#sbmt").click(function(){
    form.action="/doUpload"
 });