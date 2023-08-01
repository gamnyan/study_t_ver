<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="metro4:locale" content="ko-KR" />
<meta name="metro4:init" content="false" />

<title>Restaurant Metro</title>

<link rel="stylesheet"
	href="https://cdn.korzh.com/metroui/v4.5.1/css/metro-all.min.css" />
<style></style>
</head>
<body>
	<div data-role="appbar">
		<ul class="app-bar-menu">
			<li><a href="/jwbook/restaurantControl">결제</a></li>
			<li><a href="/jwbook/restaurant/bills.jsp">결산</a></li>
			<!-- <li><a href="/c0715/restaurant?action=bill">결제</a></li>
                <li><a href="/c0715/restaurant?action=bills">결산</a></li> -->
		</ul>
	</div>

	<br />
	<br />
	<br />

	<div class="container">
		<label>결제</label> <br />
		<table class="table" data-role="table" id="bills_table" data-rows="-1"
			data-show-pagination="false" data-show-search="false"
			data-show-rows-steps="false" data-show-table-info="false"
			data-pagination-short-mode="false"
			data-pagination-wrapper=".block-pagination-wrapper">
			<thead>
				<tr>
					<th>결제번호</th>
					<th>할인가</th>
					<th>정가</th>
					<th>결제일</th>
					<th>카드</th>
					<th>쿠폰</th>
					<th>메뉴</th>
					<th>수량</th>
				</tr>
			</thead>
			<tbody id="bills">

				<c:forEach var="order" items="" varStatus="i">
					<tr>
						<td>${i.index+1}</td>
						<td>
				</c:forEach>
				<!-- <tr>
					<td>33</td>
					<td>86000</td>
					<td>86000</td>
					<td>2023-07-31</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr> -->

				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>무제한 샐러드바</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>채끝 등심 스테이크(210g)</td>
					<td>2</td>
				</tr>
				<tr>
					<td>34</td>
					<td>17500</td>
					<td>25000</td>
					<td>2023-07-31</td>
					<td>CJ ONE 삼성카드</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>무제한 샐러드바</td>
					<td>1</td>
				</tr>
				<tr>
					<td>35</td>
					<td>17500</td>
					<td>25000</td>
					<td>2023-07-31</td>
					<td>CJ ONE 삼성카드</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>무제한 샐러드바</td>
					<td>1</td>
				</tr>
				<tr>
					<td>36</td>
					<td>83000</td>
					<td>83000</td>
					<td>2023-07-31</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>무제한 샐러드바</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>안심 스테이크(150g)</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>립아이 스테이크(220g)</td>
					<td>1</td>
				</tr>
				<tr>
					<td>37</td>
					<td>83000</td>
					<td>83000</td>
					<td>2023-07-31</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>무제한 샐러드바</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>안심 스테이크(150g)</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>립아이 스테이크(220g)</td>
					<td>1</td>
				</tr>
				<tr>
					<td>38</td>
					<td>10500</td>
					<td>25000</td>
					<td>2023-07-31</td>
					<td>OK캐시백</td>
					<td>10,000 할인쿠폰(중복할인 가능)</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>무제한 샐러드바</td>
					<td>1</td>
				</tr>
				<tr>
					<td>39</td>
					<td>90800</td>
					<td>113500</td>
					<td>2023-07-31</td>
					<td>THE CJ 카드</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>무제한 샐러드바</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>안심 스테이크(150g)</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>립아이 스테이크(220g)</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>채끝 등심 스테이크(210g)</td>
					<td>1</td>
				</tr>
				<tr>
					<td>40</td>
					<td>17500</td>
					<td>25000</td>
					<td>2023-07-31</td>
					<td>CJ ONE 신한카드</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>무제한 샐러드바</td>
					<td>1</td>
				</tr>
				<tr>
					<td>41</td>
					<td>55100</td>
					<td>58000</td>
					<td>2023-07-31</td>
					<td></td>
					<td>5% 할인쿠폰(중복할인 가능)</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>안심 스테이크(150g)</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>립아이 스테이크(220g)</td>
					<td>1</td>
				</tr>
				<tr>
					<td>42</td>
					<td>42350</td>
					<td>60500</td>
					<td>2023-07-31</td>
					<td>CJ ONE 삼성카드</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>무제한 샐러드바</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>안심 스테이크(150g)</td>
					<td>1</td>
				</tr>
				<tr>
					<td>43</td>
					<td>25000</td>
					<td>25000</td>
					<td>2023-07-31</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>무제한 샐러드바</td>
					<td>1</td>
				</tr>
				<tr>
					<td>44</td>
					<td>55500</td>
					<td>55500</td>
					<td>2023-07-31</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>무제한 샐러드바</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>채끝 등심 스테이크(210g)</td>
					<td>1</td>
				</tr>
				<tr>
					<td>45</td>
					<td>17500</td>
					<td>25000</td>
					<td>2023-07-31</td>
					<td>CJ ONE 삼성카드</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>무제한 샐러드바</td>
					<td>1</td>
				</tr>
				<tr>
					<td>46</td>
					<td>28400</td>
					<td>35500</td>
					<td>2023-07-31</td>
					<td>THE CJ 카드</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>안심 스테이크(150g)</td>
					<td>1</td>
				</tr>
				<tr>
					<td>47</td>
					<td>25000</td>
					<td>25000</td>
					<td>2023-07-31</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>무제한 샐러드바</td>
					<td>1</td>
				</tr>
				<tr>
					<td>48</td>
					<td>40233</td>
					<td>60500</td>
					<td>2023-07-31</td>
					<td>CJ ONE 삼성카드</td>
					<td>5% 할인쿠폰(중복할인 가능)</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>무제한 샐러드바</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>안심 스테이크(150g)</td>
					<td>1</td>
				</tr>
				<tr>
					<td>49</td>
					<td>4000</td>
					<td>4000</td>
					<td>2023-07-31</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>생맥주</td>
					<td>1</td>
				</tr>
				<tr>
					<td>50</td>
					<td>5200</td>
					<td>6500</td>
					<td>2023-07-31</td>
					<td>신한 Lady카드</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>자몽에이드</td>
					<td>1</td>
				</tr>
				<tr>
					<td>51</td>
					<td>104738</td>
					<td>157500</td>
					<td>2023-07-31</td>
					<td>OK캐시백</td>
					<td>5% 할인쿠폰(중복할인 가능)</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>립아이 스테이크(220g)</td>
					<td>7</td>
				</tr>
				<tr>
					<td>52</td>
					<td>52725</td>
					<td>55500</td>
					<td>2023-07-31</td>
					<td>KT 멤버십 일반 할인</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>무제한 샐러드바</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>채끝 등심 스테이크(210g)</td>
					<td>1</td>
				</tr>
				<tr>
					<td>53</td>
					<td>4000</td>
					<td>4000</td>
					<td>2023-07-31</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>생맥주</td>
					<td>1</td>
				</tr>
				<tr>
					<td>54</td>
					<td>72500</td>
					<td>72500</td>
					<td>2023-07-31</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>채끝 등심 스테이크(210g)</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>안심 스테이크(150g)</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>애플망고에이드</td>
					<td>1</td>
				</tr>
				<tr>
					<td>55</td>
					<td>83000</td>
					<td>83000</td>
					<td>2023-07-31</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>무제한 샐러드바</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>안심 스테이크(150g)</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>립아이 스테이크(220g)</td>
					<td>1</td>
				</tr>
				<tr>
					<td>56</td>
					<td>72500</td>
					<td>72500</td>
					<td>2023-07-31</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>채끝 등심 스테이크(210g)</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>안심 스테이크(150g)</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>애플망고에이드</td>
					<td>1</td>
				</tr>
				<tr>
					<td>57</td>
					<td>45150</td>
					<td>64500</td>
					<td>2023-07-31</td>
					<td>CJ ONE 삼성카드</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>무제한 샐러드바</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>안심 스테이크(150g)</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>생맥주</td>
					<td>1</td>
				</tr>
				<tr>
					<td>58</td>
					<td>20300</td>
					<td>29000</td>
					<td>2023-07-31</td>
					<td>CJ ONE 삼성카드</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>무제한 샐러드바</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>생맥주</td>
					<td>1</td>
				</tr>
				<tr>
					<td>59</td>
					<td>10500</td>
					<td>10500</td>
					<td>2023-07-31</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>애플망고에이드</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>생맥주</td>
					<td>1</td>
				</tr>
				<tr>
					<td>60</td>
					<td>40233</td>
					<td>60500</td>
					<td>2023-07-31</td>
					<td>CJ ONE 삼성카드</td>
					<td>5% 할인쿠폰(중복할인 가능)</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>무제한 샐러드바</td>
					<td>2</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>애플망고에이드</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>생맥주</td>
					<td>1</td>
				</tr>
				<tr>
					<td>61</td>
					<td>61950</td>
					<td>88500</td>
					<td>2023-07-31</td>
					<td>CJ ONE 삼성카드</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>무제한 샐러드바</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>생맥주</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>립아이 스테이크(220g)</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>채끝 등심 스테이크(210g)</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>자몽에이드</td>
					<td>1</td>
				</tr>
				<tr>
					<td>65</td>
					<td>20300</td>
					<td>29000</td>
					<td>2023-08-01</td>
					<td>CJ ONE 삼성카드</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>무제한 샐러드바</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>생맥주</td>
					<td>1</td>
				</tr>
				<tr>
					<td>66</td>
					<td>20300</td>
					<td>29000</td>
					<td>2023-08-01</td>
					<td>CJ ONE 삼성카드</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>무제한 샐러드바</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>생맥주</td>
					<td>1</td>
				</tr>
				<tr>
					<td>67</td>
					<td>4000</td>
					<td>4000</td>
					<td>2023-08-01</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>생맥주</td>
					<td>1</td>
				</tr>
				<tr>
					<td>68</td>
					<td>4000</td>
					<td>4000</td>
					<td>2023-08-01</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>생맥주</td>
					<td>1</td>
				</tr>
				<tr>
					<td>69</td>
					<td>28975</td>
					<td>30500</td>
					<td>2023-08-01</td>
					<td>KT 멤버십 일반 할인</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>채끝 등심 스테이크(210g)</td>
					<td>1</td>
				</tr>
				<tr>
					<td>70</td>
					<td>4000</td>
					<td>4000</td>
					<td>2023-08-01</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>생맥주</td>
					<td>1</td>
				</tr>
				<tr>
					<td>71</td>
					<td>25000</td>
					<td>25000</td>
					<td>2023-08-01</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>무제한 샐러드바</td>
					<td>1</td>
				</tr>
				<tr>
					<td>72</td>
					<td>25000</td>
					<td>25000</td>
					<td>2023-08-01</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>무제한 샐러드바</td>
					<td>1</td>
				</tr>
				<tr>
					<td>73</td>
					<td>38570</td>
					<td>58000</td>
					<td>2023-08-01</td>
					<td>CJ ONE 삼성카드</td>
					<td>5% 할인쿠폰(중복할인 가능)</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>안심 스테이크(150g)</td>
					<td>1</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>립아이 스테이크(220g)</td>
					<td>1</td>
				</tr>
				<tr>
					<td>74</td>
					<td>25000</td>
					<td>25000</td>
					<td>2023-08-01</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>무제한 샐러드바</td>
					<td>1</td>
				</tr>
			</tbody>
		</table>
		<div class="block-pagination-wrapper" id="bills_pagination"></div>
	</div>
	<script src="https://cdn.korzh.com/metroui/v4.5.1/js/metro.min.js"></script>
	<script src="addLocale_ko_KR.js"></script>
	<script>
		
	</script>
	<script src="bills.js" type="module"></script>
</body>
</html>