function closeModal() {
    document.getElementById("modal").style.display = "none";
}

function dangky() {
    document.getElementById("modal").style.display = "flex";
    document.getElementById("form__dangky").style.display = "block";
    document.getElementById("form__dangnhap").style.display = "none";
}

function dangnhap() {
    document.getElementById("modal").style.display = "flex";
    document.getElementById("form__dangnhap").style.display = "block";
    document.getElementById("form__dangky").style.display = "none";
}

// function keyCode(event) {
//     var x = event.keyCode;
//     if (x == 27) {
//         document.getElementById("modal").style.display = "none";
//     }
// }

// $(document).keydown(function (event) {
//     if (event.keyCode == 27) {
//         $('#modal').hide();
//     }
// });


// show pass
function showPass() {
    var x = document.getElementById("showPass");
    if (x.type === "password") {
        x.type = "text";
        document.getElementById("show_pass").style.display = "none";
        document.getElementById("hide_pass").style.display = "block";
    } else {
        x.type = "password";
        document.getElementById("hide_pass").style.display = "none";
        document.getElementById("show_pass").style.display = "block";
    }
}

function showPassConfig() {
    var x = document.getElementById("showPassConfig");
    if (x.type === "password") {
        x.type = "text";
        document.getElementById("show_pass_Config").style.display = "none";
        document.getElementById("hide_pass_Config").style.display = "block";
    } else {
        x.type = "password";
        document.getElementById("hide_pass_Config").style.display = "none";
        document.getElementById("show_pass_Config").style.display = "block";
    }
}
