<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Restaurant</title>
<style>
* {
	box-sizing: border-box;
}

button.menu {
	padding: 5px;
	margin: 5px;
	background-color: aquamarine;
	border-radius: 10px;
	font-size: large;
}

.container {
	border: 1px solid #222;
	background-color: aliceblue;
	padding: 20px;
	margin-bottom: 10px;
}

.bg-primary {
	background-color: beige !important;
}

.bg-secondary {
	background-color: bisque !important;
}

table, th, td {
	border-collapse: collapse;
}

th, td {
	border: 1px solid #222;
	padding: 10px;
}

select {
	font-size: large;
	width: 100%;
	padding: 5px;
	margin-bottom: 5px;
}

.btn-cal {
	font-size: large;
	padding: 15px;
	background-color: blueviolet;
	color: white;
	border-radius: 10px;
}
</style>
</head>

<body>
	<h2>메뉴</h2>
	<div id="divMenus" class="container"></div>
	<h2>선택한 메뉴</h2>
	<div id="divSelectedMenus" class="container bg-primary">
		<table style="width: 100%">
			<thead>
				<tr>
					<th>메뉴명</th>
					<th>가격</th>
					<th>수량</th>
					<th>합계</th>
				</tr>
			</thead>
			<tbody id="selectedMenusTb"></tbody>
			<tfoot id="selectedMenuTotal">
				<tr>
					<td colspan="3" style="text-align: right">합계</td>
					<td><strong id="total"></strong></td>
				</tr>
			</tfoot>
		</table>
	</div>
	<h2>제휴/할인카드/쿠폰</h2>
	<div id="divDiscount" class="container">
		<div>
			<select name="" id="selCREDIT"></select>
		</div>
		<div>
			<select name="" id="selTELECOM"></select>
		</div>
		<div>
			<select name="" id="selPOINT"></select>
		</div>
		<div>
			<select name="" id="selOKCASHBAG"></select>
		</div>
		<div>
			<select name="" id="selCoupons"></select>
		</div>
	</div>
	<div style="padding: 10px; text-align: center">
		<button class="btn-cal" onclick="calculateAmount();">결제 금액 계산
		</button>
	</div>
	<div id="divRealTotal" style="display: none">
		<h2>
			최종 결제 금액: <strong id="realTotal"></strong>
		</h2>
	</div>
	<script src="restaurant.js"></script>
</body>
</html>
