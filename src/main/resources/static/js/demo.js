let a = ' <div class="small-container single-product">\n' +
    '        <div class="product-row">\n' +
    '          <div class="col-2">\n' +
    '            <img\n' +
    '              src="/pictures/wear.jpg"\n' +
    '              alt=""\n' +
    '              width="100%"\n' +
    '              id="product-img"\n' +
    '            />\n' +
    '            <div class="small-img-row">\n' +
    '              <div class="small-img-col">\n' +
    '                <img\n' +
    '                  src="/pictures/wear.jpg"\n' +
    '                  alt=""\n' +
    '                  width="100%"\n' +
    '                  class="small-img"\n' +
    '                />\n' +
    '              </div>\n' +
    '              <div class="small-img-col">\n' +
    '                <img\n' +
    '                  src="/pictures/wear3.jpg"\n' +
    '                  alt=""\n' +
    '                  width="100%"\n' +
    '                  class="small-img"\n' +
    '                />\n' +
    '              </div>\n' +
    '              <div class="small-img-col">\n' +
    '                <img\n' +
    '                  src="/pictures/wear4.jpg"\n' +
    '                  alt=""\n' +
    '                  width="100%"\n' +
    '                  class="small-img"\n' +
    '                />\n' +
    '              </div>\n' +
    '              <div class="small-img-col">\n' +
    '                <img\n' +
    '                  src="/pictures/wear5.jpg"\n' +
    '                  alt=""\n' +
    '                  width="100%"\n' +
    '                  class="small-img"\n' +
    '                />\n' +
    '              </div>\n' +
    '            </div>\n' +
    '          </div>\n' +
    '          <div class="col-2">\n' +
    '            <p>HOME / WEAR</p>\n' +
    '            <h1>T-Shirts by Power Storm</h1>\n' +
    '            <h4>$29.99</h4>\n' +
    '            <div class="product-options">\n' +
    '              <select>\n' +
    '                <option>Select size</option>\n' +
    '                <option>XXL</option>\n' +
    '                <option>XL</option>\n' +
    '                <option>L</option>\n' +
    '                <option>M</option>\n' +
    '                <option>S</option>\n' +
    '                <option>XS</option>\n' +
    '              </select>\n' +
    '              <input type="number" value="1" />\n' +
    '            </div>\n' +
    '            <a href="" class="btn">Add to cart</a>\n' +
    '            <h3>Product Details</h3>\n' +
    '            <br />\n' +
    '            <p>\n' +
    '              Give your summer wardrobe a style upgrade with the Men\'s Active\n' +
    '              T-Shirt. Team it with a pair of short for your morining workout or\n' +
    '              a denims for an evening out with the boys.\n' +
    '            </p>\n' +
    '          </div>\n' +
    '        </div>\n' +
    '      </div>\n' +
    '\n' +
    '      <!-- Carousel wear -->\n' +
    '      <div class="carousel-container">\n' +
    '        <div class="carousel-header">\n' +
    '          <p>\n' +
    '            <span class="wear-mover">&#139;</span>\n' +
    '          </p>\n' +
    '          <h1 class="carousel-name">Related Products</h1>\n' +
    '          <p>\n' +
    '            <span class="wear-mover">&#155;</span>\n' +
    '          </p>\n' +
    '        </div>\n' +
    '        <section class="products">\n' +
    '          <div class="product">\n' +
    '            <picture>\n' +
    '              <img src="/pictures/wear1.jpg" alt="" />\n' +
    '            </picture>\n' +
    '            <div class="details">\n' +
    '              <p>\n' +
    '                <b>Product One</b><br />\n' +
    '                <small>New arrival</small>\n' +
    '              </p>\n' +
    '              <samp>45.00$</samp>\n' +
    '            </div>\n' +
    '            <div class="button">\n' +
    '              <p class="star">\n' +
    '                <strong>&star;</strong>\n' +
    '                <strong>&star;</strong>\n' +
    '                <strong>&star;</strong>\n' +
    '                <strong>&star;</strong>\n' +
    '                <strong>&star;</strong>\n' +
    '              </p>\n' +
    '              <a href="#">Buy</a>\n' +
    '            </div>\n' +
    '          </div>\n' +
    '        </section>\n' +
    '      </div>'


let productDetails;

productDetails.innerHTML = "<p>HOME / WEAR</p>\n" +
    "            <h1>" + product.name + " - " + chosenColor.colorName + "</h1>\n" +
    "            <h4>$" + chosenColor.price.toFixed(2) + "</h4>\n" +
    '            <div class="product-sizes">\n' +
    "            </div>\n" +
    '            <div id="colors" class="colors-available"></div>' +
    '            <div class="product-options">' +
    '            <div class="quantity-input">' +
    '              <span class="material-symbols-outlined">\n' +
    '               add\n' +
    '              </span>' +
    '              <input type="number" value="1" />\n' +
    '              <span class="material-symbols-outlined">\n' +
    '              remove\n' +
    '              </span>' +
    '            </div>' +
    '              <a href="" class="btn">Add to cart</a>\n' +
    '            </div>' +
    "            <div class='product-description'>" +
    "               <h3>Product Details</h3>\n" +
    "               <br />\n" +
    "               <p>" + product.description + "</p>\n" +
    "            </div>"

let cartItemInner;

cartItemInner.innerHTML = '<div class="card">\n' +
    '                <div class="img-box">\n' +
    '                  <img\n' +
    '                    src="/pictures/wear4.jpg"\n' +
    '                    alt="Blue wear"\n' +
    '                    width="80px"\n' +
    '                    class="product-img"\n' +
    '                  />\n' +
    '                </div>\n' +
    '\n' +
    '                <div class="detail">\n' +
    '                  <h4 class="product-name">' + cartItem.name + ' - ' + cartItem.color + '<span class="color-visual"></span>' +' - ' + cartItem.size + '</h4>\n' +
    '\n' +
    '                  <div class="wrapper">\n' +
    '                    <div class="product-qty">\n' +
    '                      <button id="decrement">\n' +
    '                        <ion-icon name="remove-outline"></ion-icon>\n' +
    '                      </button>\n' +
    '                      <span id="quantity">1</span>\n' +
    '                      <button id="increment">\n' +
    '                        <ion-icon name="add-outline"></ion-icon>\n' +
    '                      </button>\n' +
    '                    </div>\n' +
    '\n' +
    '                    <div class="price">$ <span id="price">1.25</span></div>\n' +
    '                  </div>\n' +
    '                </div>\n' +
    '\n' +
    '                <button id="product-close-btn" class="product-close-btn">\n' +
    '                  <ion-icon name="close-outline"></ion-icon>\n' +
    '                </button>\n' +
    '              </div>'


let address;

address.innerHTML = '<div class="main-address-container">' +
    '   <div class="pseudo-container">' +
    '   </div>' +
    '   <div class="address-container">' +
    '       <div>' + responseJson.address.address + '</div>' +
    '       <div>' + responseJson.address.city + ', ' + responseJson.address.postCode + '</div>' +
    '       <div>' + responseJson.address.country + '</div>' +
    '   </div>' +
    '   <div class="pseudo-container">' +
    '   </div>' +
    '</div>'

let message;

message.innerHTML = ' <span class="material-symbols-outlined"> task_alt </span> \n' +
    '        <h2 id="successful-order" class="success-message">\n' +
    '          Order successfully placed\n' +
    '        </h2>'

mainCutomers.innerHTML = '<div class="recent-orders">\n' +
    '                <h2>Customers</h2>\n' +
    '                <table>\n' +
    '                    <thead>\n' +
    '                        <tr>\n' +
    '                            <th>Name</th>\n' +
    '                            <th>Username</th>\n' +
    '                            <th>Phone</th>\n' +
    '                            <th>Address</th>\n' +
    '                            <th>Email</th>\n' +
    '                            <th>Orders</th>\n' +
    '                        </tr>\n' +
    '                    </thead>\n' +
    '                    <tbody>\n' +
    '                    </tbody>\n' +
    '                </table>\n' +
    '            </div>'
