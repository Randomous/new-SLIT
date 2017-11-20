<%-- 
    Document   : test
    Created on : Nov 15, 2017, 1:20:43 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
		<meta charset="utf-8">
		<title>SLIT Redigeringsverktøy</title>
		<script src="https://cdn.ckeditor.com/4.7.3/standard/ckeditor.js"></script>
                <script src="javascript.js"> </script>
	</head>
	<body>
            <textarea id="commentText" name="editor1"></textarea>
		<script>
                    var divID = idSetter('commentText');
			CKEDITOR.replace( divID );
		</script>

        
    </body>
</html>
