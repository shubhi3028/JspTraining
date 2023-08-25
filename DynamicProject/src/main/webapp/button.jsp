<script>
var button = document.getElementById("my-btn");

button.onclick = function() {
  this.parentNode.removeChild(button);
}
</script>