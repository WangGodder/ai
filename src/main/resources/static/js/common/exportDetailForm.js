
(function (win) {

    var id = 0;

    win.exportDetailForm = function(url, data){
        id ++;
        var formId = "export-detail-from-" + id;
        var form = $('<form target="_blank" class="hide" action="'+url+'" id="'+formId+'" method="get"></form>');

        for (var i=0; i<data.length; i++) {
        	if(typeof(data[i][1]) != 'undefined' && data[i][1] !== ''){
                var input = $('<input id="input-'+i+'" name="'+data[i][0]+'">');
                input.val(data[i][1]);
                form.append(input);

        	}
        }
        $('body').append(form);

        form.submit();

        form.remove();
    }

    win.exportDetailForm2 = function(url, data){
        id ++;
        var formId = "export-detail-from-" + id;
        var form = $('<form target="_blank" class="hide" action="'+url+'" id="'+formId+'" method="post"></form>');

        for (i in data){
            if(typeof(data[i]) != 'undefined' && null != data[i] && data[i] !== ''){
                if ('object' == typeof(data[i])){
                    var name = data[i] + '.';
                    for (j in data[i]){
                        if (typeof(data[i][j]) != 'undefined' && null != data[i][j] && data[i][j] !== ''){
                            name += j;
                            var input = $('<input id="input-'+name+'" name="'+name+'">');
                            input.val(data[i][j]);
                            form.append(input);
                        }
                    }

                    continue;
                }
                var input = $('<input id="input-'+i+'" name="'+i+'">');
                input.val(data[i]);
                form.append(input);
            }
        }
        $('body').append(form);

        form.submit();

        form.remove();
    }

    win.exportDetailForm3 = function(url, data){
        id ++;
        var formId = "export-detail-from-" + id;
        var form = $('<form target="_blank" class="hide" action="'+url+'" id="'+formId+'" method="get"></form>');

        for (i in data){
            if(typeof(data[i]) != 'undefined' && null != data[i] && data[i] !== ''){
                if ('object' == typeof(data[i])){
                    var name = data[i] + '.';
                    for (j in data[i]){
                        if (typeof(data[i][j]) != 'undefined' && null != data[i][j] && data[i][j] !== ''){
                            name += j;
                            var input = $('<input id="input-'+name+'" name="'+name+'">');
                            input.val(data[i][j]);
                            form.append(input);
                        }
                    }

                    continue;
                }
                var input = $('<input id="input-'+i+'" name="'+i+'">');
                input.val(data[i]);
                form.append(input);
            }
        }
        $('body').append(form);

        form.submit();

        form.remove();
    }

})(window||{})




