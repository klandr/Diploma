<!DOCTYPE>
<html>
<head>
    <title>WouldSell WouldBuy</title>
</head>
<body>
<H1>WouldSell WouldBuy</H1>
<hr>
<h4>Details info about item</h4>
<b> Name Item: </b>${item.title}<br>
<b> Describe Item: </b>${item.description}<br>
<b> Price: </b>${item.price}<br>
<b> Town: </b>${item.town}<br>
<b> Seller Name: </b>${item.author}<br>
<hr>
<h3>Create a new item</h3>
<form action="/item/dell/${id}" method="post">
    <input type="submit" value="Delete Item"/>
</form>

</body>
</html>