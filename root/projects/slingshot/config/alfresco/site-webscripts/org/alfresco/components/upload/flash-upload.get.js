/**
 * Custom content types
 */
function getContentTypes()
{
   // TODO: Data webscript call to return list of available types
   var contentTypes = [
   {
      id: "cm:content",
      value: "cm_content"
   }];

   return contentTypes;
}

model.contentTypes = getContentTypes();

// Widget instantiation metadata...
model.widgets = [];
var flashUpload = {};
flashUpload.name = "Alfresco.FlashUpload";
flashUpload.useOptions = false;
flashUpload.useMessages = true;
model.widgets.push(flashUpload);
