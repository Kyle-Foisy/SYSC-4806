var AddressBookSearcher = {
    get_AddressBook: (function() {
        var inputValue = $('#id').val();
        var neededURL = 'https://new-kylefoisyaddressbook-d0b8gwead4ahf3f5.eastus2-01.azurewebsites.net/books?id=${inputValue}'
        neededURL.replace("${inputValue}", inputValue)
        $.ajax({
            url: neededURL,
            type: 'GET',
        }).then(function(data) {
        $('.addressBook-id').append(data.id);
        $('.addressBook-buddies').append(data.content);
    });
})}


$(document).ready(function() {




});