<!DOCTYPE>
<html>
<head>
    <title>WouldSell WouldBuy</title>
</head>
<body>
<H1>WouldSell WouldBuy</H1>
<hr>
<h4>Items over of the world</h4>
<form action="/" method="get">
    Find title of advertisement: <input type="text" name="title"><br>
    <input type="submit" value="Find"/>
</form>
<#list items as item>
    <div>
        <p><b> ${item.title}</b> ${item.price} eur. | <a href="/item/${item.id}"> Details...</a></p>
    </div>
    <#else>
    <h3>There isn't any items</h3>
</#list>
<hr>
<h3>Create a new item</h3>
<form action="/item/create" method="post">
    Name of item: <input type="text" name="title"/><br><br>
    Describe Advertisement: <input type="text" name="description"/><br><br>
    Price: <input type="number" name="price"/> eur <br><br>
    Town: <input type="text" name="town"/><br><br>
    Seller Name: <input type="text" name="author"/><br><br>
    <input type="submit" value="Add item"/>
</form>
</body>
</html>