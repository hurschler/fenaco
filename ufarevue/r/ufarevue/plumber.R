#
# This is a Plumber API. You can run the API by clicking
# the 'Run API' button above.
#
# Find out more about building APIs with Plumber here:
#
#    https://www.rplumber.io/
#

library(plumber)

#* @apiTitle Plumber Example API

#* Echo back the input
#* @param search The message to echo
#* @get /echo
function(search = "") {
    list(search1 = paste0("The message is: '", search, "'"))
    list(search2 = paste0("The message is: '", search, "'"))
    list(search3 = paste0("The message is: '", search, "'"))
      paste0("The q parameter is '", 'André', "'. ",
           "The pretty parameter is '", 'Hurschler', "'.")
}

#' @post /user
function(req, id, name){
  list(
    id = id,
    name = name,
    raw = req$postBody
  )
}



#* Plot a histogram
#* @png
#* @get /plot
function() {
    rand <- rnorm(100)
    hist(rand)
}

#* Return the sum of two numbers
#* @param a The first number to add
#* @param b The second number to add
#* @post /sum
function(a, b) {
    as.numeric(a) + as.numeric(b)
}
