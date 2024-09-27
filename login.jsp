<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
	<link rel="stylesheet" href="assets/css/vertical-layout-light/login1.css">
</head>
<body>
<div class="container" id="container">
	<div class="form-container sign-up-container">
		<form action="#">
			<h1>Créer un compte ?</h1>
			<div class="social-container">
				<a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
				<a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
				<a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
			</div>
			<span>Veuillez remplir les champs</span>
			<input type="text" placeholder="Veuillez entrer votre Nom" />
			<input type="email" placeholder="Veuillez entrer votre Email" />
			<input type="password" placeholder="Veuillez entrer votre Mot de passe" />
			<button>S'inscrire</button>
		</form>
	</div>
	<div class="form-container sign-in-container">
		<form action="#">
			<h1>Connexion</h1>
			<div class="social-container">
				<a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
				<a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
				<a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
			</div>
			<span>Veuillez remplir les champs</span>
			<input type="email" placeholder="Veuillez entrer votre Email" />
			<input type="password" placeholder="Veuillez entrer votre Mot de passe" />
			<a href="#">Mot de passe oublié ?</a>
			<button>Se connecter</button>
		</form>
	</div>
	<div class="overlay-container">
		<div class="overlay">
			<div class="overlay-panel overlay-left">
				<h1>HAZ'R</h1>
				<p></p>
				<button class="ghost" id="signIn">Se connecter</button>
			</div>
			<div class="overlay-panel overlay-right">
				<h1>HAZ'R</h1>
				<p></p>
				<button class="ghost" id="signUp">S'inscrire</button>
			</div>
		</div>
	</div>
</div>

<footer>

</footer>

<script>
    const signUpButton = document.getElementById('signUp');
	const signInButton = document.getElementById('signIn');
	const container = document.getElementById('container');

	signUpButton.addEventListener('click', () => {
		container.classList.add("right-panel-active");
	});

	signInButton.addEventListener('click', () => {
		container.classList.remove("right-panel-active");
});

</script>
</body>
</html>
