<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        /*
        $(document).ready(function () {
            // Function to handle checkbox change event
            $('input[type="checkbox"]').change(function () {
                var checkedValues = [];		// Array to store checked values

                // loop through all checkboxes
                $('input[type="checkbox"]:checked').each(function () {
                    checkedValues.push($(this).val());	// Add checked value to the array
                });

                // display the checked values
                $('#result').text("Checked Values: " + checkedValues.join(", "));
            });
        });
        */
    </script>
</head>
<body>
<h3>Checkboxes: </h3>
<input type="checkbox" name="checkbox" value="Value 1">Value 1<br>
<input type="checkbox" name="checkbox" value="Value 2">Value 2<br>
<input type="checkbox" name="checkbox" value="Value 3">Value 3<br><br>

<button id="myButton" onclick="myClickHandler()">Click me!</button>

<div id="result"></div>

<script>

function myClickHandler() {
    $(function () {

        // get all the checkboxes with the name "checkbox"
        var checkboxes = $("input[type=checkbox][name=checkbox]");
        console.log(checkboxes);

        // get the checked checkboxes
        var checkedCheckboxes = checkboxes.filter(":checked");

        // get the values of the checked checkboxes
        var checkedValues = [];
        checkedCheckboxes.each(function () {
            checkedValues.push($(this).val());
        });

        // do something with the checked values
        console.log("value: " + checkedValues);
    });
}
</script>
</body>
</html>