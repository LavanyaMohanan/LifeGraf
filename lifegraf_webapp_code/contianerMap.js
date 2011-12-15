
var CA = { "mcdonald" : 7.57, "coke" : 1.76, "milk" : 2.00, "bread" : 2.42, "beer" : 3.13, "rent": 957, "transport": 2.69, "utility": 201, "nike": 97, "cinema": 11.75  } ;
var CN = { "mcdonald" : 4.15, "coke" : 0.59, "milk" : 1.70, "bread" : 1.39, "beer" : 1.10, "rent": 461, "transport": 0.32, "utility": 29.64, "nike": 93.76, "cinema": 9.51  } ;
var IN = { "mcdonald" : 3.79, "coke" : 0.42, "milk" : 0.63, "bread" : 0.40, "beer" : 1.63, "rent": 176, "transport": 0.28, "utility": 36, "nike": 62, "cinema": 3.71  } ;
var US = { "mcdonald" : 6, "coke" : 1.5, "milk" : 1.14, "bread" : 2.31, "beer" : 3.16, "rent": 897, "transport": 1.94, "utility": 207, "nike": 81, "cinema": 9.5  } ;
var GB = { "mcdonald" : 7.90, "coke" : 1.95, "milk" : 1.5, "bread" : 1.76, "beer" : 4.56, "rent": 977, "transport": 3.53, "utility": 199, "nike": 94, "cinema": 11.75  } ;

var beerOBJ= { "imagesrc":"./image/beer.png", "width" : "75", "height" : "75", "LEFT":"2", "top":"0", "object_width" : "38", "num_width": "75", "num_height":"75", "max_num":"170"};
var cokeOBJ= {"imagesrc":"./image/coke.png", "width" : "75",  "height" : "75", "LEFT":"8", "top":"0", "object_width" : "40", "num_width": "75", "num_height":"75", "max_num":"180"};
var breadOBJ= {"imagesrc":"./image/bread.png", "width" : "75",  "height" : "75", "LEFT":"8", "top":"0", "object_width" : "38", "num_width": "75", "num_height":"75", "max_num":"150"};
var milkOBJ= {"imagesrc":"./image/milk.png", "width" : "75",  "height" : "85", "LEFT":"4", "top":"0", "object_width" : "50", "num_width": "75", "num_height":"75", "max_num":"120"};
var burgerOBJ= {"imagesrc":"./image/burger.png", "width" : "75",  "height" : "55", "LEFT":"4", "top":"0", "object_width" : "74", "num_width": "75", "num_height":"75", "max_num":"75"};

var utilityOBJ= { "imagesrc":"./image/utility.jpg", "o_width" : "200", "o_height" : "200", "o_left":"10%", "o_top":"0%", "linksrc" : "utility"};
var rentOBJ= { "imagesrc":"./image/rent.jpg", "o_width" : "200", "o_height" : "200", "o_left":"10%", "o_top":"0%", "linksrc" : "rent"};
var transportOBJ= { "imagesrc":"./image/public_transportation.png", "o_width" : "200", "o_height" : "200", "o_left":"0%", "o_top":"10%", "linksrc" : "transport"};
var shoeOBJ= { "imagesrc":"./image/shoe.png", "o_width" : "200", "o_height" : "200", "o_left":"10%", "o_top":"0%", "linksrc" : "nike"};
var cinemaOBJ= { "imagesrc":"./image/movie_ticket.png", "o_width" : "200", "o_height" : "60", "o_left":"10%", "o_top":"40%", "linksrc" : "cinema"};

    var selected_country_1=CA;
    var selected_country_2=US;

    var commodity_cost;
    var object_cost;
    var selected_object='beer';
    var selected_commodity='shoe';

    function getNumberOfObjects() {
        return Math.floor(commodity_cost / object_cost);
    }

    function fillCommodityContainer(div_id){
        $(div_id).empty();
        var realObject=getRealObject(selected_commodity);
        addImagePercent(div_id, realObject.imagesrc, realObject.o_width, realObject.o_height, realObject.o_top, realObject.o_left,realObject.linksrc);
    };




    function fillContainer(div_id){
        $(div_id).empty();
        $(div_id).height("400px");

        var total_number_of_object;
        var top=0;
        var left;

        total_number_of_object = Math.floor(commodity_cost/object_cost);
        var selectedObject = getRealObject(selected_object);

        var number_of_fill_object_in_line=Math.floor(($(div_id).width())/selectedObject.object_width);
        var number_of_line=total_number_of_object/number_of_fill_object_in_line;
        var k;

        for(k=0;k<total_number_of_object;k++){
            top=20*Math.floor(k/number_of_fill_object_in_line);
            left=-selectedObject.LEFT+selectedObject.object_width*(k%number_of_fill_object_in_line);
            addImage(div_id, selectedObject.imagesrc, selectedObject.width, selectedObject.height, top, left);
        }
    };


    function addImage(div_id, imagesrc, width, height, top, left) {
        $(div_id).append('<img src="' + imagesrc + '" width="' + width + '" height="' + height + '" style="position:absolute;top: ' + top + 'px;left: ' + left + 'px;"/></a>');
    };

    function addImagePercent(div_id, imagesrc, width, height, top, left,linksrc) {
        $(div_id).append('<a href="javascript:void(0);" title="'+linksrc+'"><img src="' + imagesrc + '" width="' + width + '" height="' + height + '" style="position:relative;top:'+top+'"/></a>');
    };

    function selectCommodity(type,object_li){
        $(object_li).parent().find('li.selected').each(function(){
            $(this).removeClass('selected');
        });
        $(object_li).addClass('selected');
        selected_commodity=type;
        updateCommodityPrice();
    };


    function selectObject(type,object_li){
        $(object_li).parent().find('li.selected').each(function(){
            $(this).removeClass('selected');});

        $(object_li).addClass('selected');
        selected_object=type;
        updateObjectPrice();
    };

    function updateObjectPrice() {
        if (selected_object == 'beer')        object_cost = selected_country_2.beer;
        else if (selected_object == 'coke')   object_cost = selected_country_2.coke;
        else if (selected_object == 'bread')  object_cost = selected_country_2.bread;
        else if (selected_object == 'milk')   object_cost = selected_country_2.milk;
        else                                  object_cost = selected_country_2.mcdonald;
    }

    function updateCommodityPrice() {
        if (selected_commodity == 'rent')           commodity_cost = selected_country_1.rent;
        else if (selected_commodity == 'transport') commodity_cost = selected_country_1.transport;
        else if (selected_commodity == 'utility')   commodity_cost = selected_country_1.utility;
        else if (selected_commodity == 'shoe')      commodity_cost = selected_country_1.nike;
        else                                        commodity_cost = selected_country_1.cinema;
    }


function drawNumericGraph(object_div) {
    var realObject = getRealObject(selected_object);
    var src = realObject.imagesrc;
    if(realObject.max_num<=getNumberOfObjects())
        $('.image_graph_label').hide();
    else
        {
            $('.image_graph_label').show();
            $('.numeric_graph_label').show();
        }

    var image = "<img src='" + getRealObject(selected_object).imagesrc + "' width='" + realObject.num_width + "' height=" + realObject.num_height + "/>"
    var div = "<div style='padding: 35px 0 0 0px; font-size: 67px; color: #AAA; font-family: cambria; margin-left: 81px;'> " + getNumberOfObjects() + " x [" + image + "] </div>";
    $(object_div).empty();
    $(object_div).height("170px");
    $(object_div).append(div);
}

function displayNumericGraph(object_div,self){
    $(self).parent().parent().find('.selected_graph_type').addClass('unselected_graph_type');
    $(self).parent().parent().find('.selected_graph_type').removeClass('selected_graph_type');
    $(self).parent().addClass('selected_graph_type');
    drawGraph();

};

function displayImageGraph(object_div,self){
    $(self).parent().parent().find('.selected_graph_type').addClass('unselected_graph_type');
    $(self).parent().parent().find('.selected_graph_type').removeClass('selected_graph_type');
    $(self).parent().addClass('selected_graph_type');
    drawGraph();
};

function updateSelectedCountry_1(val){
    switch(val){
        case 'CA':selected_country_1=CA;break;
        case 'CN':selected_country_1=CN;break;
        case 'IN':selected_country_1=IN;break;
        case 'US':selected_country_1=US;break;
        case 'GB':selected_country_1=GB;break;
    }
    updateCommodityPrice();
    drawGraph();
}

function drawGraph() {
    var graph_type;
    var num = $('.graph_type').length;

    if (num == 1)
        graph_type = $('.graph_type').text().trim();
    else
        graph_type = $('.selected_graph_type').text().trim();
    
    if (graph_type == "Numeric")
        {
            $('.image_graph_label').removeClass('selected_graph_type');
            $('.image_graph_label').addClass('unselected_graph_type');
            $('.numeric_graph_label').addClass('selected_graph_type');
            drawNumericGraph($('.object_container .display_container'));

        }
    else if (graph_type == "Image")
        {
            $('.numeric_graph_label').removeClass('selected_graph_type');
            $('.numeric_graph_label').addClass('unselected_graph_type');
            $('.image_graph_label').addClass('selected_graph_type');

            fillContainer($('.object_container .display_container'));
        }
}

function updateSelectedCountry_2(val){
    switch(val){
        case 'CA':selected_country_2=CA;break;
        case 'CN':selected_country_2=CN;break;
        case 'IN':selected_country_2=IN;break;
        case 'US':selected_country_2=US;break;
        case 'GB':selected_country_2=GB;break;
    }
    updateObjectPrice();
    drawGraph();
}

function getRealObject(selected_object){
    switch(selected_object){
        case 'beer':return beerOBJ;
        case 'milk':return milkOBJ;
        case 'coke':return cokeOBJ;
        case 'bread':return breadOBJ;
        case 'burger':return burgerOBJ;
        case 'utility':return utilityOBJ;
        case 'rent':return rentOBJ;
        case 'transport':return transportOBJ;
        case 'shoe':return shoeOBJ;
        case 'cinema':return cinemaOBJ;
    }
}

function hidecarousel1(){
    setTimeout(function(){$('.mycarousel').hide()},4000);
}

function hidecarousel2(){
    setTimeout(function(){$('.mycarousel2').hide()},4000);
}
