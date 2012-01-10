
function argument_url(db, argid)
{
    return '/argument/' + db + '/' + argid;
}

function set_argument_url(db, argid)
{
    $.address.value(argument_url(db, argid));
}

function display_argument(db, argid)
{
    ajax_get('argument-info/' + db + '/' + argid,
            function(argument_data) {
                argument_data.normalize();
                argument_data.direction = argument_data.pro ? "pro" : "con";
                argument_data.db = db;
                set_description_text(argument_data);
                set_argument_title_text(argument_data);
                argument_data.conclusion.statement_prefix = argument_data.conclusion.pro ? "pro" : "con";
                argument_data.conclusion.statement_text = statement_text(argument_data.conclusion);
                set_premises_text(argument_data);
                set_undercutters_text(argument_data);
                set_rebuttals_text(argument_data);
                set_dependents_text(argument_data);
                var argument_html = ich.argument(argument_data);
                $('body').html(argument_html.filter('#argument'));
            });
}

function set_premises_text(argument_data)
{
    $.each(argument_data.premises, 
           function(index, premise) {
               premise.statement.statement_text = statement_text(premise.statement, index + 1);
           });
}

function set_argument_title_text(info)
{
    var default_text = "Argument";
    if(info.header) {
        info.argument_title_text = info.header.title ? info.header.title['en'] : default_text;
    } else {
        info.argument_title_text = default_text;
    }
}

function set_undercutters_text(info)
{
    $.each(info.undercutters_data, 
           function(index, data) {
               data.argument_text = argument_text(data, index + 1);
               data.id = info.undercutters[index];
               set_premises_text(data);
           });  
}

function set_rebuttals_text(info)
{
    $.each(info.rebuttals_data,
          function(index, data) {
              data.argument_text = argument_text(data, index + info.undercutters_data.length);
              data.id = info.rebuttals[index];
              set_premises_text(data);
          });
}

function set_dependents_text(info)
{
    $.each(info.dependents_data,
          function(index, data) {
              data.statement_text = statement_text(data, index + 1);
              data.id = info.dependents[index];
          });
}

// returns a text representing the argument, ie., its title
// or a default text if none
function argument_text(data, index)
{
    var text;
    if(data.header && data.header.title) {
        text = data.header.title;
    } else {
        if(index == undefined) {
            text = 'Argument';
        } else {
            text = 'Argument #' + index;            
        }
    }
    return text;
}
