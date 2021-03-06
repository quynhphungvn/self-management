hljs.configure({   // optionally configure hljs
	languages: ['javascript', 'ruby', 'python', 'java', 'html']
});
var myToolbar = [
	['bold', 'italic', 'underline', 'strike'],        // toggled buttons
	['blockquote', 'code-block'],

	[{ 'header': 1 }, { 'header': 2 }],               // custom button values
	[{ 'list': 'ordered' }, { 'list': 'bullet' }],
	[{ 'script': 'sub' }, { 'script': 'super' }],      // superscript/subscript
	[{ 'indent': '-1' }, { 'indent': '+1' }],          // outdent/indent
	[{ 'direction': 'rtl' }],                         // text direction

	[{ 'size': ['small', false, 'large', 'huge'] }],  // custom dropdown
	[{ 'header': [1, 2, 3, 4, 5, 6, false] }],

	[{ 'color': [] }, { 'background': [] }],          // dropdown with defaults from theme
	[{ 'font': [] }],
	[{ 'align': [] }],
	['link', 'image'],
	['clean']                                      // remove formatting button	
];
var quill = new Quill('#editor', {
	modules: {
		syntax: true,
		toolbar: {
			container: myToolbar,
			handlers: {
				image: imageHandler
			}
		}
	},
	theme: 'snow'
});
function imageHandler() {
	var range = this.quill.getSelection();
	var value = prompt('please copy paste the image url here.');
	if (value) {
		this.quill.insertEmbed(range.index, 'image', value, Quill.sources.USER);
	}
} 