let total = 0;

function calculateTotalAmount() {
	let lineSum = document.getElementsByClassName("line-sum");
	total = 0;
	for (let l of lineSum) {
		total += parseInt(l.value);
	}

	document.getElementById("total").innerText = total;
}

function changeLineSum(e, price) {
	let qty = e.target.value;
	let lineSum =
		e.target.parentNode.parentNode.getElementsByClassName("line-sum")[0];
	lineSum.value = price * parseInt(qty);

	calculateTotalAmount();
}

let oSelectFood = {};

function selectFood(event) {
	//let menuId = parseInt(event.target.innerText);
	let menuId = '무제한 샐러드바';

	const menu = menus.filter((m) => m.menuId == menuId)[0];
	if (oSelectFood[menu.menuId]) {
		return alert("이미 추가된 메뉴입니다.");
	}

	oSelectFood[menu.menuId] = menu;

	let tr = [];
	tr.push("<tr>");
	tr.push(`<td>${menu.menuName}</td>`);
	tr.push(`<td>${menu.price}</td>`);
	tr.push(
		`<td><input type="number" value="1" step="1" min="1" style="width:100%;" onchange="changeLineSum(event, ${menu.price});"></td>`
	);
	tr.push(
		`<td><input type="text" value="${menu.price * 1
		}" style="width:100%;" class="line-sum" readonly></td>`
	);
	tr.push("</tr>");
	document
		.getElementById("selectedMenusTb")
		.insertAdjacentHTML("beforeend", tr.join(""));

	calculateTotalAmount();
}

function loadMenus() {
	let h = [];
	for (let menu of menus) {
		h.push(
			// `<button class="menu" onclick="selectFood(${menu.menuId});">${menu.menuName}(${menu.price}원)</button>`
			`<button class="menu" data-menu-id="${menu.menuId}">${menu.menuName}(${menu.price}원)</button>`
		);
	}

	document.getElementById("divMenus").innerHTML = h.join("");

	let menuIdButtons = document.getElementsByClassName("menu");
	for (const menuIdButton of menuIdButtons) {
		menuIdButton.addEventListener("click", selectFood);
		console.log(menuIdButton);
	}
}

function loadCards() {
	let oCards = {};

	for (let card of creditCards) {
		if (!oCards[card.cardType]) {
			oCards[card.cardType] = [];
		}

		oCards[card.cardType].push(card);
	}
	console.log(oCards);

	for (let key in oCards) {
		let h = [];
		h.push(
			`<option value="">${cardTypes.filter((c) => c.cardType == key)[0].title
			} 선택하세요.</option>`
		);
		for (card of oCards[key]) {
			h.push(`<option value="${card.discount}">${card.cardName}</option>`);
		}

		document.getElementById("sel" + key).innerHTML = h.join("");
	}

	let h = [];
	h.push('<option value="">할인쿠폰을 선택하세요.</option>');
	for (let coupon of coupons) {
		h.push(`<option value="${coupon.couponId}">${coupon.title}</option>`);
	}

	document.getElementById("selCoupons").innerHTML = h.join("");
}

/**
 * json
 */
let menus = [];
let cardTypes = [];
let creditCards = [];
let coupons = [];

async function fetchThenLoad() {
	const responseMenus = await fetch("http://localhost:3000/menus");
	const responseCardTypes = await fetch("http://localhost:3000/cardTypes");
	const responseCreditCards = await fetch("http://localhost:3000/creditCards");
	const responseCoupons = await fetch("http://localhost:3000/coupons");

	menus = await responseMenus.json();
	cardTypes = await responseCardTypes.json();
	creditCards = await responseCreditCards.json();
	coupons = await responseCoupons.json();
	loadMenus();
	loadCards();
}

function calculateAmount() {
	let realTotal = 0;

	if (total == 0) {
		return alert("메뉴를 먼저 선택하세요.");
	}

	let discount = 0;
	for (let type of cardTypes) {
		if (document.getElementById("sel" + type.cardType).value != "") {
			let cardDiscount = parseInt(
				document.getElementById("sel" + type.cardType).value
			);
			if (cardDiscount > discount) {
				discount = cardDiscount;
			}
		}
	}

	let couponId = document.getElementById("selCoupons").value;
	let coupon = null;
	if (couponId != "") {
		coupon = coupons.filter((c) => c.couponId == couponId)[0];
	}

	realTotal = total;

	if (coupon != null && coupon.doubleDiscount) {
		// 중복할인 가능
		let discountAmount = 0;
		if (coupon.discountType == "%") {
			// %할인
			discountAmount = Math.round(total * (coupon.discount / 100));
		} else {
			// 정액할인
			discountAmount = coupon.discount;
		}

		console.log(discountAmount);

		realTotal = realTotal - discountAmount;
		console.log(realTotal);
		if (discount > 0) {
			realTotal = realTotal - Math.round(realTotal * (discount / 100));
		}
	} else {
		// 중복할인 불가능
		if (discount > 0) {
			const discountAmount = Math.round(realTotal * (discount / 100));
			console.log(discountAmount);
			if (coupon != null) {
				if (discountAmount > coupon.discount) {
					realTotal = realTotal - discountAmount;
				} else {
					realTotal = realTotal - coupon.discount;
				}
			} else {
				realTotal = realTotal - discountAmount;
			}
		} else {
			if (coupon != null) {
				let discountAmount = 0;
				if (coupon.discountType == "%") {
					discountAmount = Math.round(total * (coupon.discount / 100));
				} else {
					discountAmount = coupon.discount;
				}
				console.log(discountAmount);

				realTotal = realTotal - discountAmount;
			}
		}
	}

	document.getElementById("realTotal").innerText = realTotal + "원";
	document.getElementById("divRealTotal").style.display = "";
}

window.addEventListener("load", function() {
	fetchThenLoad();
});

// 0524(62082) 0530(68307) 0531(10112) 0605(9234) 0609(2170) 0619(11485) 0623(9213) 0624(62105) 0630(9755) 0630(68307) 0705(9200) 77150*3
console.log(62082 + 68307 + 10112 + 77150 * 3);