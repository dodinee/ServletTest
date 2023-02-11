<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculator</title>
<style>
	input{
	width:50px;
	height:50px;
	}
	.output{
	width:50px;
	background:pink;
	font-size:24px;
	font-weight:bold;
	text-align : right;
	padding:0px 5px;
	}
</style>
</head>
<body>
	<form action="calc3" method=post>
		<table>
			<tr>
				<td colspan="4" class="output">${3+4}</td>
			</tr>
			<tr>
				<td><input type="submit" name="operator" value="ce"></td>
				<td><input type="submit" name="operator" value="c"></td>
				<td><input type="submit" name="operator" value="bs"></td>
				<td><input type="submit" name="operator" value="//"></td>
			</tr>
			<tr>
				<td><input type="submit" name="value" value="7"></td>
				<td><input type="submit" name="value" value="8"></td>
				<td><input type="submit" name="value" value="9"></td>
				<td><input type="submit" name="operator" value="x"></td>
			</tr>
			<tr>
				<td><input type="submit" name="value" value="4"></td>
				<td><input type="submit" name="value" value="5"></td>
				<td><input type="submit" name="value" value="6"></td>
				<td><input type="submit" name="operator" value="-"></td>
			</tr>
			<tr>
				<td><input type="submit" name="value" value="1"></td>
				<td><input type="submit" name="value" value="2"></td>
				<td><input type="submit" name="value" value="3"></td>
				<td><input type="submit" name="operator" value="+"></td>
			</tr>
			<tr>
				<td><input type="submit" name="value" value="0"></td>
				<td><input type="submit" name="dot" value="."></td>
				<td><input type="submit" name="operator" value="="></td>
			</tr>
		</table>
	</form>
</body>
</html>