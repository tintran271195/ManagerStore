<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <title>Cart</title>
    <link href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css' rel='stylesheet'>
    <link href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css' rel='stylesheet'>
    <style>@import url('https://fonts.googleapis.com/css?family=Open+Sans&display=swap');

    body {
        background-color: #eeeeee;
        font-family: 'Open Sans', serif;
        font-size: 14px
    }

    .container-fluid {
        margin-top: 70px
    }

    .card-body {
        -ms-flex: 1 1 auto;
        flex: 1 1 auto;
        padding: 1.40rem
    }

    .img-sm {
        width: 80px;
        height: 80px
    }

    .itemside .info {
        padding-left: 15px;
        padding-right: 7px
    }

    .table-shopping-cart .price-wrap {
        line-height: 1.2
    }

    .table-shopping-cart .price {
        font-weight: bold;
        margin-right: 5px;
        display: block
    }

    .text-muted {
        color: #969696 !important
    }

    a {
        text-decoration: none !important
    }

    .card {
        position: relative;
        display: -ms-flexbox;
        display: flex;
        -ms-flex-direction: column;
        flex-direction: column;
        min-width: 0;
        word-wrap: break-word;
        background-color: #fff;
        background-clip: border-box;
        border: 1px solid rgba(0, 0, 0, .125);
        border-radius: 0px
    }

    .itemside {
        position: relative;
        display: -webkit-box;
        display: -ms-flexbox;
        display: flex;
        width: 100%
    }

    .dlist-align {
        display: -webkit-box;
        display: -ms-flexbox;
        display: flex
    }

    [class*="dlist-"] {
        margin-bottom: 5px
    }

    .coupon {
        border-radius: 1px
    }

    .price {
        font-weight: 600;
        color: #212529
    }

    .btn.btn-out {
        outline: 1px solid #fff;
        outline-offset: -5px
    }

    .btn-main {
        border-radius: 2px;
        text-transform: capitalize;
        font-size: 15px;
        padding: 10px 19px;
        cursor: pointer;
        color: #fff;
        width: 100%
    }

    .btn-light {
        color: #ffffff;
        background-color: #F44336;
        border-color: #f8f9fa;
        font-size: 12px
    }

    .btn-light:hover {
        color: #ffffff;
        background-color: #F44336;
        border-color: #F44336
    }

    .btn-apply {
        font-size: 11px
    }</style>
    <script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
    <script type='text/javascript'
            src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js'></script>
    <script type='text/javascript'></script>
</head>
<body oncontextmenu='return false' class='snippet-body'>
<div class="container-fluid">
    <div class="row">
        <aside class="col-lg-9">
            <div class="card">
                <div class="table-responsive">
                    <table class="table table-borderless table-shopping-cart">
                        <thead class="text-muted">
                        <tr class="small text-uppercase">
                            <th>#</th>
                            <th scope="col">Product</th>
                            <th scope="col" width="120">Quantity</th>
                            <th scope="col" width="120">Price</th>
                            <th scope="col" class="text-right d-none d-md-block" width="200">Sub Total</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:set var="total" value="0"></c:set>
                        <c:forEach items="${order.items}" var="item">
                            <c:set var="total" value="${total + item.product.price * item.quantity}"></c:set>
                            <tr>
                                <td>${item.product.id}</td>
                                <td>
                                    <figure class="itemside align-items-center">
                                        <div class="aside"><img src="${item.product.image}" class="img-sm"></div>
                                        <figcaption class="info"><a href="#" class="title text-dark"
                                                                    data-abc="true">${item.product.name}</a>
                                        </figcaption>
                                    </figure>
                                </td>
                                <td>${item.quantity}</td>
                                <td>
                                    <div class="price-wrap"><var class="price">$ ${item.product.price}</var></div>
                                </td>
                                <td>
                                    $ ${item.product.price * item.quantity}
                                </td>
                                <td class="text-right d-none d-md-block"><a data-original-title="Save to Wishlist"
                                                                            title=""
                                                                            href="" class="btn btn-light"
                                                                            data-toggle="tooltip" data-abc="true"> <i
                                        class="fa fa-heart"></i></a> <a href="removecart?pid=${item.product.id}" class="btn btn-light" data-abc="true">
                                    Remove</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </aside>
        <aside class="col-lg-3">
            <div class="card mb-3">
                <div class="card-body">
                    <form>
                        <div class="form-group"><label>Have coupon?</label>
                            <div class="input-group"><input type="text" class="form-control coupon" name=""
                                                            placeholder="Coupon code"> <span class="input-group-append"> <button
                                    class="btn btn-primary btn-apply coupon">Apply</button> </span></div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="card">
                <div class="card-body">
                    <dl class="dlist-align">
                        <dt>Total price:</dt>
                        <dd class="text-right ml-3">${total}</dd>
                    </dl>
                    <dl class="dlist-align">
                        <dt>Discount:</dt>
                        <dd class="text-right text-danger ml-3">- $0</dd>
                    </dl>
                    <dl class="dlist-align">
                        <dt>Total:</dt>
                        <dd class="text-right text-dark b ml-3"><strong>${total}</strong></dd>
                    </dl>
                    <hr>
                    <a href="${sessionScope.acc == null ? "login" : "puschase"}" class="btn btn-out btn-primary btn-square btn-main" data-abc="true"> Make
                        Purchase </a>
                    <a href="home" class="btn btn-out btn-success btn-square btn-main mt-2" data-abc="true">Continue
                        Shopping</a>
                </div>
            </div>
        </aside>
    </div>
</div>
</body>
</html>

